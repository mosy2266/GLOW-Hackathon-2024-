import React from "react";
import { introText } from "../constants";
 // Assuming you have a separate SCSS file for styling

 const Intro = () => {
    return (
        <section id="intro" className="intro-section">
            <div className="intro-inner">
                <h1 className="intro-title">{introText.title}</h1>
                <div className="intro-content">
                    <div className="intro-text">
                        {introText.desc.map((text, index) => (
                            <p key={index}>{text}</p>
                        ))}
                    </div>
                </div>
            </div>
        </section>
    );
}

export default Intro;

