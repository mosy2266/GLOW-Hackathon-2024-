import React, { useState } from "react";
import { useNavigate } from "react-router-dom";


const Signup = () => {
    const [formData, setFormData] = useState({ username: "", password: "" });
    const navigate = useNavigate();

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        // 회원가입 로직을 추가합니다 (예: API 호출) 아마 백엔드가 할듯??
        console.log("회원가입 정보:", formData);
        // 회원가입 성공 시 홈 또는 다른 페이지로 이동
        navigate("/");
    };

    return (
        <div className="signup">
            <h2>회원가입</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <label htmlFor="username">사용자 이름:</label>
                    <input
                        type="text"
                        id="username"
                        name="username"
                        value={formData.username}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div>
                    <label htmlFor="password">비밀번호:</label>
                    <input
                        type="password"
                        id="password"
                        name="password"
                        value={formData.password}
                        onChange={handleChange}
                        required
                    />
                </div>
                <button type="submit">회원가입</button>
            </form>
        </div>
    );
};

export default Signup;

