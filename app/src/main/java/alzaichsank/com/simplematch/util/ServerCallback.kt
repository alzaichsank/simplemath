package alzaichsank.com.simplematch.util

/**
 * Created by alzaichsank on 1/24/18.
 */
interface ServerCallback {
    fun onSuccess(response: String)

    fun onFailed(response: String)

    fun onFailure(throwable: Throwable)
}