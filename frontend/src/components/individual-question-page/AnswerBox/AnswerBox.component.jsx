import {
  useHandleLikeCountUpdate,
} from './AnswerBox.hooks';
import './AnswerBox.styles.css';

const AnswerBox = ({ data }) => {
  const { likeCount, disLikeCount, updateLikeCount, updateDislikeCount } = useHandleLikeCountUpdate(data.id);

  return (
    <article className={'answer-box'}>
      <div className={'flex-container'}>
        <div className={'counters'}>
          <span className={'like'}>Liked {likeCount} times.</span>
          <span className={'dislike'}>Disliked {disLikeCount} times.</span>
        </div>
        <p className={'text-body'}>{data.description}</p>
      </div>
      <div className={'footer'}>
        <div className={'buttons'}>
          <button onClick={updateLikeCount}>LIKE</button>
          <button onClick={updateDislikeCount}>DISLIKE</button>
        </div>
        <div className={'signature'}>
          Answered on <span>{new Date(data.createdAt).toLocaleString()}</span> by <span>{data.userName}</span>
        </div>
      </div>
    </article>
  );
};

export default AnswerBox;
