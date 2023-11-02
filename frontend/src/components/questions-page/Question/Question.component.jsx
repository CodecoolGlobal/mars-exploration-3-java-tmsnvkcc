import './Question.styles.css';
import {Link} from "react-router-dom";

const Question = ({ data }) => {
  return (
    <article className={'question-container'}>
      <div className={'stat-container'}>
        <span className={'answer-box'}>{data.numberOfAnswers} answers</span>
        <span className={'views-box'}>{data.numberOfViews} views</span>
      </div>
      <Link to={`/questions/id/${data.id}`}>{data.title}</Link>
      <span className={'date'}><span>asked on</span> {new Date(data.createdAt).toLocaleString()} <span>by</span> {data.userName}</span>
    </article>
  );
};

export default Question;
