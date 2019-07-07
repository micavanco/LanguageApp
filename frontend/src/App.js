import React from 'react';
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
          <HighScorePage/>
      </div>
      <Footer/>
    </div>
  );
}

export default App;
