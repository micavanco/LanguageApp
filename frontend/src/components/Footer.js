import React, {Component} from 'react';
import './Footer.css';

export default class Footer extends Component{

    render()
    {
        return(
            <div className="bottom-bar">
                <div className="app-logo">Language App</div>
                <div className="contact-box">
                    <div className="contact-info">Email: michal.olech.mail@gmail.com</div>
                    <div className="contact-info">Phone: 513514703</div>
                </div>
                <div className="year-info">Michał Olech © 2019</div>
            </div>
        );
    }
}