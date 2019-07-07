import React, {Component} from 'react';
import './NavBar.css';

export default class NavBar extends Component{

    render()
    {
        return(
            <div className={"nav-container"}>
                <div className={"logo"}>OLECH</div>
                <div className={"nav-btn"}>Login</div>
                <div className={"nav-btn"}>Best Score</div>
                <div className={"nav-btn"}>Learning</div>
            </div>
        );
    }
}