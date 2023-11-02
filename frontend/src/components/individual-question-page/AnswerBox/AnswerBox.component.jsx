import './AnswerBox.styles.css';

const AnswerBox = ({ data }) => {
  return (
    <article className={'answer-box'}>
      <div className={'flex-container'}>
        <div className={'counters'}>
          <span className={'like'}>Liked {data.numberOfLikes} times.</span>
          <span className={'dislike'}>Disliked {data.numberOfDislikes} times.</span>
        </div>
        <p className={'text-body'}>{data.description}</p>
      </div>
      <div className={'footer'}>
        <div className={'buttons'}>
          <button>LIKE</button>
          <button>DISLIKE</button>
        </div>
        <div className={'signature'}>
          Answered on <span>{new Date(data.createdAt).toLocaleString()}</span> by <span>{data.userName}</span>
        </div>
      </div>
    </article>
  );
};

export default AnswerBox;
