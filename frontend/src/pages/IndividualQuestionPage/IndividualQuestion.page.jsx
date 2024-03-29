import {
  AddNewAnswer,
  AnswerBox,
  QuestionBox,
} from 'components/individual-question-page';
import {
  useHandleQuestionDetailsLoader,
  useHandleViewCountUpdate,
} from './IndividualQuestionPage.hooks';
import './IndividualQuestionPage.styles.css';

const IndividualQuestionPage = () => {
  const { loading, data } = useHandleQuestionDetailsLoader();
  useHandleViewCountUpdate();

  if (loading) {
    return (
      <div>Loading data...</div>
    );
  }

  return (
    <section className={'individual-question-page'}>
      <QuestionBox
        title={data.title}
        description={data.description}
        createdAt={data.createdAt}
        numberOfViews={data.numberOfViews}
        postedBy={data.userName}
      />
      <p className={'answer-number'}>{data.answerForSingleQuestionDTOs.length} {data.answerForSingleQuestionDTOs.length === 1 ? 'answer' : 'answers'}.</p>
      {data.answerForSingleQuestionDTOs.map((answer) => <AnswerBox key={answer.id} data={answer} />)}
      <AddNewAnswer />
    </section>
  );
};

export default IndividualQuestionPage;
