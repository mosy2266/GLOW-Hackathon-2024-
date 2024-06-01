import React, { useState } from "react";
import { Link } from "react-router-dom";
import SignupModal from "./Auth/Signup";
import LoginModal from "./Auth/Login";
import { useUser } from "./UserContext";
import { headerNav } from "../constants"; // headerNav를 import 합니다.
import Button from 'react-bootstrap/Button';
import 'bootstrap/dist/css/bootstrap.min.css';

const Header = () => {
    const [show, setShow] = useState(false);
    const [isSignupOpen, setIsSignupOpen] = useState(false);
    const [isLoginOpen, setIsLoginOpen] = useState(false);
    const { user, setUser } = useUser();

    const toggleMenu = () => {
        setShow((prevShow) => !prevShow);
    }

    const openSignupModal = () => {
        setIsLoginOpen(false); // Close login modal if open
        setIsSignupOpen(true);
    }

    const closeSignupModal = () => {
        setIsSignupOpen(false);
    }

    const openLoginModal = () => {
        setIsSignupOpen(false); // Close signup modal if open
        setIsLoginOpen(true);
    }

    const closeLoginModal = () => {
        setIsLoginOpen(false);
    }

    const handleLogout = () => {
        setUser(null);
    }

    return (
        <header id="header" role="banner">
            <div className="header__inner">
                <div className="header__logo">
                    <h1>
                        <Link to="/">축제를 제맛대로<em>음흠냐으음</em></Link>
                    </h1>
                </div>
                <nav 
                    className={`header__nav ${show ? "show" : ""}`} 
                    role="navigation" 
                    aria-label="메인메뉴"
                >
                    <ul>
                        {headerNav.map((nav, key) => (
                            <li key={key}>
                                <Link to={nav.url}>{nav.title}</Link>
                            </li>
                        ))}
                    </ul>
                </nav>
    
                <div className="header__auth">
                    {user ? (
                        <>
                            <span>{user.nickname}님</span>
                            <Button variant="outline-primary" onClick={handleLogout} className="header__auth__link">로그아웃</Button>
                        </>
                    ) : (
                        <>
                            <Button variant="outline-primary" onClick={openLoginModal} className="header__auth__link">로그인</Button>
                            <Button variant="outline-primary" onClick={openSignupModal} className="header__auth__link">회원가입</Button>
                        </>
                    )}
                </div>
                <div 
                    className="header__nav__mobile" 
                    id="headerToggle" 
                    aria-controls="primary-menu" 
                    aria-expanded={show ? "true" : "false"} 
                    role="button"
                    tabIndex="0"
                    onClick={toggleMenu}
                    onKeyPress={toggleMenu}
                >
                    <span></span>
                </div>
            </div>
            {isLoginOpen && <LoginModal closeModal={closeLoginModal} />}
            {isSignupOpen && <SignupModal closeModal={closeSignupModal} />}
        </header>
    )
}

export default Header;

