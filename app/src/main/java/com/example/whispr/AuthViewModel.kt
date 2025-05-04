package com.example.whispr

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.LiveData

class AuthViewModel: ViewModel() {
    private val auth: FirebaseAuth= FirebaseAuth.getInstance()
    private val _auth_state= MutableLiveData<Auth_State>()
    val auth_state=_auth_state

    init {
        check_auth_status()
    }
    fun check_auth_status()
    {
        if(auth.currentUser==null){
            _auth_state.value= Auth_State.unauthenticated
        }
        else{
            _auth_state.value= Auth_State.authenticated
        }
    }

    fun login(email:String,password:String)
    {
        if(email.isEmpty()||password.isEmpty())
        {
            _auth_state.value= Auth_State.Error("Email or password can't be empty")
            return
        }
        _auth_state.value= Auth_State.loading
        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener {task->
                if(task.isSuccessful){
                    _auth_state.value= Auth_State.authenticated
                }
                else{
                    _auth_state.value= Auth_State.Error("Invalid email or password. Please try again.")
                }
            }
    }
    fun signup(email: String,password:String)
    {
        if(email.isEmpty()||password.isEmpty())
        {
            _auth_state.value= Auth_State.Error("Email or password can't be empty")
            return
        }
        _auth_state.value= Auth_State.loading
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener {task->
                if(task.isSuccessful)
                {
                    _auth_state.value= Auth_State.authenticated
                }
                else
                {
                   _auth_state.value= Auth_State.Error("Unexpected error occurred")
                }
            }

    }
    fun signout()
    {
        auth.signOut()
        _auth_state.value= Auth_State.unauthenticated
    }
}

sealed class Auth_State{
    object authenticated: Auth_State()
    object unauthenticated: Auth_State()
    object loading: Auth_State()
    data class Error(val message: String): Auth_State()
}