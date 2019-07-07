import React, {Component} from 'react';
import './SignUpPage.css';

export default class SignUpPage extends Component{

    render()
    {
        return(
            <div className={"main-container"}>
                <h1>Sign Up</h1>
                <input className={"input-object"} placeholder={"Username"}/>
                <input className={"input-object"} placeholder={"Password"}/>
                <input className={"input-object"} placeholder={"Confirm Password"}/>
                <input className={"input-object"} placeholder={"Age"}/>
                <select className={"input-object"}>
                    <option value={"male"} defaultValue>Male</option>
                    <option value={"female"}>Female</option>
                </select>
                <input className={"input-object"} placeholder={"City"}/>
                <div className={"login-btn"}>Sign Up</div>
            </div>
        );
    }
}