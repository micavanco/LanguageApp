import React, {Component} from 'react';
import './MainPage.css';

export default class MainPage extends Component{

    constructor(params)
    {
        super(params);

        this.state = {language: null};
    }

    render()
    {
        if(this.state.language)
            return(

                <div className={"main-container"}>
                    <div className={"question"}>Jeg vet ikke hva gjor jeg</div>
                    <input className={"learning-input"} placeholder={"Type the answer"}/>
                    <div className={"details-container"}>
                        <div className={"info-container"}>
                            <h5>Points: 23</h5>
                            <h5>Question: 23</h5>
                        </div>
                        <div className={"check-btn"}>Check</div>
                    </div>
                </div>
            );
        else
            return(
                <div className={"main-container"}>
                    <select className={"input-object"}>
                        <option className={"options"} value={"Norwegian"} defaultValue>Norwegian</option>
                        <option className={"options"} value={"Spanish"}>Spanish</option>
                        <option className={"options"} value={"German"}>German</option>
                    </select>
                    <div className={"login-btn"} onClick={this.onBtnClick.bind(this)}>Start Quiz</div>
                </div>
            );

    }

    onBtnClick(e)
    {
        const selectElement = e.target.previousSibling;
        this.setState({language: selectElement.options[selectElement.selectedIndex].value});
    }
}