import React, { useEffect } from "react";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import HomeView from "./views/HomeView";
import smooth from "./utils/smooth";
import link from "./utils/link";
import Port from "./components/Port";
import Signup from "./components/Signup"; 
import Submit from "./components/Submit";


const App = () => {
    useEffect(() => {
        smooth();
        link();
    }, []);

    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<HomeView />} />
                <Route path="/port" element={<Port />} />
                <Route path="/signup" element={<Signup />} /> 
                <Route path="/submit"element={<Submit/>}/>
   
            </Routes>
        </BrowserRouter>
    );
};

export default App;