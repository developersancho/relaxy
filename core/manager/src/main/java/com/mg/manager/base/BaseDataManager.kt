package com.mg.manager.base

import com.mg.remote.network.NetworkState
import com.mg.remote.network.RemoteDataException
import kotlinx.coroutines.Deferred
import retrofit2.Response

abstract class BaseDataManager {

    protected suspend fun <T : Any> apiCallResponse(call: suspend () -> Response<T>): NetworkState<T> {
        return try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null)
                    NetworkState.Success(body)
                else
                    NetworkState.Empty("no json body")
            } else {
                NetworkState.Error(RemoteDataException(response.errorBody()))
            }

        } catch (ex: Throwable) {
            NetworkState.Error(RemoteDataException(ex))
        }
    }

    protected suspend fun <T : Any> apiCall(call: suspend () -> T): NetworkState<T> {
        return try {
            val response = call()
            NetworkState.Success(response)
        } catch (ex: Throwable) {
            NetworkState.Error(RemoteDataException(ex))
        }
    }

    protected suspend inline fun <reified T : Any> apiCallDeferred(request: Deferred<Response<T>>): NetworkState<T> {
        return try {
            val response = request.await()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null)
                    NetworkState.Success(body)
                else
                    NetworkState.Empty("no json body")
            } else {
                NetworkState.Error(RemoteDataException(response.errorBody()))
            }
        } catch (ex: Throwable) {
            NetworkState.Error(RemoteDataException(ex))
        }
    }
}