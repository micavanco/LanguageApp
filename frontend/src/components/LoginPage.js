import React, {Component} from 'react';
import axios from 'axios';
import './LoginPage.css';

export default class LoginPage extends Component{

    constructor(params)
    {
        super(params);

        this.state = {isAuthorized: true};
    }

    onSubmitClick(e)
    {
        const username = e.target.previousSibling.previousSibling.previousSibling.value;
        const password = e.target.previousSibling.previousSibling.value;
        console.log(username, password);
        axios.get('http://localhost:8080/v1/user/login',
            {
                params: {
                    username: username,
                    password: password
                }
            }).then( res => {
                sessionStorage.setItem('user_id', res.data.id);
                sessionStorage.setItem('username', username);
                sessionStorage.setItem('password', password);
                sessionStorage.setItem('user_name', res.data.name);
                sessionStorage.setItem('user_surname', res.data.surname);
                sessionStorage.setItem('user_city', res.data.city);
                sessionStorage.setItem('user_createdAt', res.data.createdAt);
                this.setState({isAuthorized: true});
                document.getElementById("learning").click();
            })
            .catch(err => {this.setState({isAuthorized: false})});

    }

    render()
    {
        let Warning = '';
        if(!this.state.isAuthorized)
            Warning = (<div style={{color: 'red'}}>Username and/or password is incorrect...</div>);

        return(
            <div className={"main-container"}>
                <h1>Login</h1>
                <input type={"text"} className={"input-object"} placeholder={"Username"}/>
                <input type={"password"} className={"input-object"} placeholder={"Password"}/>
                {Warning}
                <div className={"login-btn"} onClick={this.onSubmitClick.bind(this)}>Login</div>
                <a className={"signUp-btn"} href={"/signup"}>New Here?</a>
            </div>
        );
    }
}