import { useHandleNewAnswerSubmission } from "./AddNewAnswer.hooks";
import './AddNewAnswer.styles.css';

const AddNewAnswer = () => {
  const { submitAnswer } = useHandleNewAnswerSubmission();

  return (
    <form className={'new-answer-form'} onSubmit={submitAnswer}>
      <textarea id={'newAnswer'} name={'newAnswer'} placeholder={'Write your reply here...'}></textarea>
      <input type={"submit"} value={'SUBMIT'} />
    </form>
  );
};

export default AddNewAnswer;
