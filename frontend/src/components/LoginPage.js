import React, {Component} from 'react';
import './LoginPage.css';

export default class LoginPage extends Component{

    render()
    {
        return(
            <div className={"main-container"}>
                <h1>Login</h1>
                <input className={"input-object"} placeholder={"Username"}/>
                <input className={"input-object"} placeholder={"Password"}/>
                <div className={"login-btn"}>Login</div>
                <a className={"signUp-btn"} href={"/signup"}>New Here?</a>
            </div>
        );
    }
}