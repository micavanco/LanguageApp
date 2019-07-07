import React, {Component} from 'react';
import './MainPage.css';

export default class MainPage extends Component{

    render()
    {
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
    }
}