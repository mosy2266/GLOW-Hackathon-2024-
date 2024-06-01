import React, { useState } from 'react';
import { CheckBox } from '../CheckBox';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

const BoardWrite = () => {
  const navigate = useNavigate();

  const [board, setBoard] = useState({
    title: '',
    createdBy: '',
    contents: '',
  });

  const { title, createdBy, contents } = board; //비구조화 할당

  const [attend, setAttend] = React.useState(false); // 축제 참가 여부


  const onChange = (event) => {
    const { value, name } = event.target; //event.target에서 name과 value만 가져오기
    setBoard({
      ...board,
      [name]: value,
    });
  };

  const saveBoard = async () => {
    await axios.post(`//localhost:8080/board`, board).then((res) => {
      alert('등록되었습니다.');
      navigate('/board');
    });
  };

  const backToList = () => {
    navigate('/board');
  };

  return (
    <div>
      <div>
        <span>축제 이름</span>
        <br/>
        <input type="text" name="title" value={title} onChange={onChange} />
      </div>
      <br />
      <div>
        <CheckBox checked={attend} onChange_check={setAttend} >지난번 축제 참여 여부</CheckBox>
      </div>
      <br />
      <div>
        <span>축제 공모 내용</span>
        <br/>
        <textarea
          name="contents"
          cols="100"
          rows="10"
          value={contents}
          onChange={onChange}
        ></textarea>
      </div>
      <br />
      <div>
        <span>파일 업로드</span>
     
      </div>

      <br />
      <div>
        <button onClick={saveBoard}>저장</button>
        <button onClick={backToList}>취소</button>
      </div>
    </div>
  );
};

export default BoardWrite;