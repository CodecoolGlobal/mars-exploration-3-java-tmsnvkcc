import useHandleQuestionDetailsLoader from './IndividualQuestionPage.hooks';

const IndividualQuestionPage = () => {
  const { loading, data } = useHandleQuestionDetailsLoader();

  if (loading) {
    return (
      <div>Loading data...</div>
    );
  }

  return (
    <>
      there will be data here
    </>
  );
};

export default IndividualQuestionPage;
