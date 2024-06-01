import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useUser } from "../UserContext";
import axios from "axios";
import './Auth.css'; // 스타일을 위한 CSS 파일
import Button from 'react-bootstrap/Button';
import 'bootstrap/dist/css/bootstrap.min.css';

const Signup = ({ closeModal }) => {
    const [email, setEmail] = useState('');
    const [username, setUsername] = useState('');
    const [userNickname, setUserNickname] = useState('');
    const [phoneNumber, setPhoneNumber] = useState('');
    const [password, setPassword] = useState('');
    const [confirmPassword, setConfirmPassword] = useState('');
    const [role, setRole] = useState('');
    const { setUser } = useUser();
    const navigate = useNavigate();

    const handleSignup = async (event) => {
        event.preventDefault();

        if (password !== confirmPassword) {
            alert("비밀번호가 일치하지 않습니다.");
            return;
        }

        const payload = {
            email: email,
            password: password,
            nickname: userNickname,
            name: username,
            phone: phoneNumber,
            role: role,
        };

        try {
            const response = await axios.post('http://43.202.9.215:8080/signup', payload);

            if (response.status === 200) {
                const responseData = response.data;
                // 회원가입이 성공하면 유저 상태를 설정하고 로그인 상태로 전환
                setUser({
                    email: email,
                    nickname: userNickname
                });
                closeModal();
                navigate('/');
            } else {
                // 회원가입 실패 시 처리
                alert('회원가입에 실패했습니다. 다시 시도해주세요.');
            }
        } catch (error) {
            console.error('Error during signup:', error);
            alert('오류가 발생했습니다. 다시 시도해주세요.');
        }
    };

    return (
        <div className="auth-container">
            <h2>회원가입</h2>
            <form onSubmit={handleSignup}>
                <div className="form-group">
                    <label htmlFor="email">이메일</label>
                    <input
                        type="email"
                        id="email"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                        required
                    />
                </div>
                <div className="form-group">
                    <label htmlFor="username">이름</label>
                    <input
                        type="text"
                        id="username"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                        required
                    />
                </div>
                <div className="form-group">
                    <label htmlFor="userNickname">닉네임</label>
                    <input
                        type="text"
                        id="userNickname"
                        value={userNickname}
                        onChange={(e) => setUserNickname(e.target.value)}
                        required
                    />
                </div>
                <div className="form-group">
                    <label htmlFor="phoneNumber">전화번호</label>
                    <input
                        type="tel"
                        id="phoneNumber"
                        value={phoneNumber}
                        onChange={(e) => setPhoneNumber(e.target.value)}
                        required
                    />
                </div>
                <div className="form-group">
                    <label htmlFor="password">비밀번호</label>
                    <input
                        type="password"
                        id="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        required
                    />
                </div>
                <div className="form-group">
                    <label htmlFor="confirmPassword">비밀번호 확인</label>
                    <input
                        type="password"
                        id="confirmPassword"
                        value={confirmPassword}
                        onChange={(e) => setConfirmPassword(e.target.value)}
                        required
                    />
                </div>
                <div className="form-group">
                    <label htmlFor="role">역할</label>
                    <input
                        type="text"
                        id="role"
                        value={role}
                        onChange={(e) => setRole(e.target.value)}
                        required
                    />
                </div>
                <Button variant="outline-light" type="submit">회원가입</Button>
            </form>
        </div>
    );
};

export default Signup;