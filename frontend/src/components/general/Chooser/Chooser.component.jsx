import './Chooser.style.css';
import image from './pics/pensive-man-with-question-marks-with-text.jpg';
import { Link } from 'react-router-dom';

const Chooser = () => {
  return (
    <div className={'home-chooser-box'}>
      <div className={'to-questions'}>
        <Link to='/questions' className='list'>
          <img src={image} alt={'questions'}/>
        </Link>
      </div>
      <div className={'ask-a-question'}>
        <Link to='/question/new' className='list'>
          <img src={image} alt={'ask a question'}/>
        </Link>
      </div>
    </div>
  );
};

export default Chooser;
