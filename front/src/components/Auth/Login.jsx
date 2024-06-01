import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useUser } from "../UserContext";
import axios from "axios";
import './Auth.css'; // 스타일을 위한 CSS 파일
import Button from 'react-bootstrap/Button';
import 'bootstrap/dist/css/bootstrap.min.css';

const Login = ({ closeModal }) => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const { setUser } = useUser();
    const navigate = useNavigate();

    const handleLogin = async (e) => {
        e.preventDefault();

        const payload = {
            email: email,
            password: password
        };

        try {
            const response = await axios.post('http://43.202.9.215:8080/login', payload);

            if (response.status === 200) {
                const responseData = response.data;
                // 로그인 성공 시 유저 상태를 설정하고 홈 화면으로 이동
                setUser({
                    email: email,
                    nickname: responseData.nickname // Assuming the response contains a nickname field
                });
                closeModal();
                navigate('/');
            } else {
                // 로그인 실패 시 처리
                alert('로그인에 실패했습니다. 다시 시도해주세요.');
            }
        } catch (error) {
            console.error('Error during login:', error);
            alert('오류가 발생했습니다. 다시 시도해주세요.');
        }
    };

    return (
        <div className="auth-container">
            <h2>로그인</h2>
            <form onSubmit={handleLogin}>
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
                    <label htmlFor="password">비밀번호</label>
                    <input
                        type="password"
                        id="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        required
                    />
                </div>
                <Button type="submit" variant="primary">로그인</Button>
            </form>
        </div>
    );
};

export default Login;