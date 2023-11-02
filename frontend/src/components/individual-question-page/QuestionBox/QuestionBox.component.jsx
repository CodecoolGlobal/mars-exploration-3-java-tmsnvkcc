import './Questionbox.styles.css';

const QuestionBox = ({ title, description, createdAt, numberOfViews, postedBy }) => {
  return (
    <article className={'question-box'}>
      <h2>{title}</h2>
      <div className={'information'}>
        Asked on <span>{new Date(createdAt).toLocaleString()}</span> by <span>{postedBy}</span> Viewed <span>{numberOfViews}</span> times.
      </div>
      <p className={'description'}>{description}</p>
    </article>
  );
};

export default QuestionBox;
