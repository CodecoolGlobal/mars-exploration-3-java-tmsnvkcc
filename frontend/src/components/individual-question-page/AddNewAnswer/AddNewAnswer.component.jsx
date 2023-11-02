import './AddNewAnswer.styles.css';

const AddNewAnswer = () => {
  return (
    <form className={'new-answer-form'}>
      <textarea id={'newAnswer'} name={'newAnswer'} placeholder={'Write your reply here...'}></textarea>
      <input type={"button"} value={'SUBMIT'} />
    </form>
  );
};

export default AddNewAnswer;
