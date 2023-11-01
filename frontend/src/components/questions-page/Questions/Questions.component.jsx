import { Question } from "components/questions-page";

const Questions = ({ data }) => {
  return (
    <section className={'questions-container'}>
      {data.map((question) => <Question key={question.id} data={question} />)}
    </section>
  );
};

export default Questions;
