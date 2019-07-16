import React, {Component} from 'react';
import './NavBar.css';

export default class NavBar extends Component{

    constructor(props){
        super(props);

        this.buttonRef = [React.createRef(), React.createRef(),React.createRef()];
    }

    onNavButtonClick(e)
    {
        localStorage.setItem('active-btn', e.target.innerText);
    }

    onLogoClicked()
    {
        localStorage.setItem('active-btn', "Learning");
    }

    render()
    {
        return(
            <div className={"nav-container"}>
                <a className={"logo"}
                   href={"/"}
                   onClick={this.onLogoClicked}>OLECH</a>
                <a ref={this.buttonRef[0]}
                   className={"nav-btn"}
                   href={"/login"}
                   onClick={this.onNavButtonClick.bind(this)}>Login</a>
                <a ref={this.buttonRef[1]}
                   className={"nav-btn"}
                   href={"/highscore"}
                   onClick={this.onNavButtonClick.bind(this)}>Best Score</a>
                <a ref={this.buttonRef[2]}
                   className={"nav-btn"}
                   href={"/"}
                   onClick={this.onNavButtonClick.bind(this)}>Learning</a>
            </div>
        );
    }

    componentDidMount() {
        const current = localStorage.getItem('active-btn');
        this.buttonRef.forEach(e=>{
            if(e.current.outerText === current)
                e.current.style.borderBottom = "1px solid #686580";
            else
                e.current.style.textDecoration = "none";
        });
    }
}