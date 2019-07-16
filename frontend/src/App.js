import React from 'react';
import {BrowserRouter, Route} from "react-router-dom";
import NavBar from './components/NavBar';
import './App.css';
import MainPage from "./components/MainPage";
import Footer from "./components/Footer";
import LoginPage from "./components/LoginPage";
import SignUpPage from "./components/SignUpPage";
import HighScorePage from "./components/HighScorePage";

function App() {
  return (
    <div className="App">
      <NavBar/>
      <div className={"container"}>
          <BrowserRouter>
              <Route path="/" exact component={MainPage}/>
              <Route path="/highscore" component={HighScorePage}/>
              <Route path="/login" component={LoginPage}/>
              <Route path="/signup" component={SignUpPage}/>
          </BrowserRouter>
      </div>
      <Footer/>
    </div>
  );
}

export default App;
