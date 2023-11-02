import "./AddQuestion.css";
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

const AddQuestionPage = () => {
  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");
  const navigate = useNavigate();
  const handleFormSubmit = async (e) => {
    e.preventDefault();
    await fetch(
        "/api/questions/",
        {
          method: "POST",
          headers: {
            "Content-Type": "application/json"
          },
          body: JSON.stringify({
            title: title,
            description: description
              })
        })
    navigate("/");
  }


  return (
    <div>
      <h1>Add a new question!</h1>
        <form onSubmit={handleFormSubmit} >
          <label>
            Question title:
            <input
                name="title"
                value={title}
                onChange={event => setTitle(event.target.value)}
            />
          </label>
          <label>
            Description:
            <textarea
                name="description"
                value={description}
                onChange={event=> setDescription(event.target.value)}
            />
          </label>
          <button type={"submit"} >Ask!</button>
        </form>
    </div>
  );
};

export default AddQuestionPage;
