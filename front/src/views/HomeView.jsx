import React from "react";
import Header from "../components/Header";
import Intro from "../components/Intro";
import Skill from "../components/Skill";
import Port from "../components/Port";
import Footer from "../components/Footer";
import Main from "../components/Main";

const HomeView = () => {
  return (
    <>
        <Header />
        <Main>
          <Intro />
          <Footer />
          <Skill />
          <Port />
        </Main>
    </>
  )
}

export default HomeView