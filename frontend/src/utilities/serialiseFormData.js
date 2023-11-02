const serialiseFormData = (data) => {
  const formatData = [...new FormData(data).entries()];

  const reducedFormData = formatData.reduce((acc, curr) => {
    const [key, value] = curr;

    acc[key] = value;

    return acc;
  }, {});

  return reducedFormData;
};

export default serialiseFormData;
