import React, { useEffect, useRef } from "react";
import { portText } from "../constants";
import { gsap } from "gsap";
import { ScrollTrigger } from "gsap/ScrollTrigger";
import { useNavigate } from "react-router-dom";

const Port = () => {
    const horizontalRef = useRef(null);
    const sectionRef = useRef([]);
    const navigate = useNavigate();

    useEffect(() => {
        gsap.registerPlugin(ScrollTrigger);

        const horizontal = horizontalRef.current;
        const sections = sectionRef.current;

        let scrollTween = gsap.to(sections, {
            xPercent: -120 * (sections.length - 1),
            ease: "none",
            scrollTrigger: {
                trigger: horizontal,
                start: "top 56px",
                end: () => "+=" + horizontal.offsetWidth,
                pin: true,
                scrub: 1,
                markers: false,
                invalidateOnRefresh: true,
                anticipatePin: 1,
            }
        })

        return () => {
            scrollTween.kill();
        };
    }, []);

    const handleNavigate = (path) => {
        navigate(path);
    }

    return (
        <section id="port" ref={horizontalRef}>
            <div className="port__inner">
                <h2 className="port__title">
                    공모 가능 축제 <em>공모 하러 가기</em>
                </h2>
                <div className="port__wrap">
                    {portText.map((port, key) => (
                        <article 
                            className={`port__item p${key+1}`} 
                            key={key}
                            ref={(el) => (sectionRef.current[key] = el)}
                        >
                            <span className="num">{port.num}.</span>
                            <a 
                                href={port.code} 
                                target="_blank" 
                                className="img" 
                                rel="noreferrer noopener"
                            >
                                <img src={port.img} alt={port.name} />
                            </a>
                            <h3 className="title">{port.title}</h3>
                            <p className="desc">{port.desc}</p>
                            <button 
                                onClick={() => handleNavigate(port.view)} 
                                className="site"
                            >
                                공모하러 가기
                            </button>
                        </article>
                    ))}
                </div>
            </div>
        </section>
    )
}

export default Port;

