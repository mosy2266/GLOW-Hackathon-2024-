import React ,{useEffect} from 'react';

import { Link } from 'react-router-dom';

const Footer = () => {
    return (
        <footer id="footer" role="contentinfo">
            <div className="footer__inner">
                <div className="login-container">
                    <div className="login-title">
                        <Link to="/signup">sign up</Link>
                    </div>
                    <p className="login-desc">회원가입을 하시면 자신이 커스텀한 축제를 제출할 수 있습니다.</p>
                    <form className="login-form">
                        <input type="text" placeholder="Username" className="login-input" />
                        <input type="password" placeholder="Password" className="login-input" />
                        <button type="submit" className="login-button">Login</button>
                    </form>
                </div>
            </div>
        </footer>
    )
}
  
export default Footer;


