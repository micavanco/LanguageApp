import React from 'react';
import NavBar from './components/NavBar';
import './App.css';
import MainPage from "./components/MainPage";
import Footer from "./components/Footer";

function App() {
  return (
    <div className="App">
      <NavBar/>
      <div className={"container"}>
          <MainPage/>
      </div>
      <Footer/>
    </div>
  );
}

export default App;
