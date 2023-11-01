import './Question.styles.css';

const Question = ({ data }) => {
  return (
    <article className={'question-container'}>
      <div className={'stat-container'}>
        <span className={'answer-box'}>{data.numberOfAnswers} answers</span>
        <span className={'views-box'}>{data.numberOfViews} views</span>
      </div>
      <h2>{data.title}</h2>
      <span className={'date'}>asked on {new Date(data.createdAt).toLocaleString()} by {data.userName}</span>
    </article>
  );
};

export default Question;
