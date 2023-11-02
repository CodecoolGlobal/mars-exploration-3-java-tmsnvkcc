import { useParams } from "react-router-dom";
import { useHandleNewAnswerSubmission } from "./AddNewAnswer.hooks";
import './AddNewAnswer.styles.css';

const AddNewAnswer = () => {
  const { submitAnswer } = useHandleNewAnswerSubmission();
  const { id } = useParams();

  return (
    <form className={'new-answer-form'} onSubmit={submitAnswer}>
      <input id={'questionId'} name={'questionId'} type={'hidden'} value={id} />
      <textarea id={'newAnswer'} name={'newAnswer'} placeholder={'Your reply comes here...'}></textarea>
      <input type={"submit"} value={'SUBMIT'} />
    </form>
  );
};

export default AddNewAnswer;
