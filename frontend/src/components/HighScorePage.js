import React, {Component} from 'react';
import './HighScorePage.css';
import UserScoreRow from "./UserScoreRow";

export default class HighScorePage extends Component{

    render()
    {
        return(
            <div className={"main-container"}>
                <h1>High Score</h1>
                <select className={"input-object"}>
                    <option value={"norwegian"} defaultValue>Norwegian</option>
                    <option value={"german"}>German</option>
                </select>
                <div className={"table-container"}>
                    <UserScoreRow
                        number={1}
                        username={"John Walker"}
                        score={"324"}
                        leader={true}
                    />
                    <UserScoreRow
                        number={2}
                        username={"Bob Dwane"}
                        score={"123"}
                        leader={false}
                    />
                </div>
            </div>
        );
    }
}