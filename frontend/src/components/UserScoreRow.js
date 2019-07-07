import React, {Component} from 'react';
import './UserScoreRow.css';

export default class UserScoreRow extends Component{

    render()
    {
        let top = null;
        if(this.props.leader)
            top = {color: "#DA9A2A"};

        return(
            <div className={"user-container"}>
                <div style={top} className={"number"}>{this.props.number}.</div>
                <div style={top} className={"username"}>{this.props.username}</div>
                <div className={"score"}>{this.props.score}</div>
            </div>
        );
    }
}