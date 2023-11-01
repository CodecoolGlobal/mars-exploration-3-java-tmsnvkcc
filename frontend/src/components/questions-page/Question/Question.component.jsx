import './Question.styles.css';

const Question = ({ data }) => {
  return (
    <article className={'question-container'}>
      <div className={'stat-container'}>
        <span className={'answer-box'}>{data.numberOfAnswers} answers</span>
        <span className={'views-box'}>{data.numberOfViews} views</span>
      </div>
      {/*Title h2 will need to be updated into a Link component*/}
      <h2>{data.title}</h2>
      <span className={'date'}><span>asked on</span> {new Date(data.createdAt).toLocaleString()} <span>by</span> {data.userName}</span>
    </article>
  );
};

export default Question;
