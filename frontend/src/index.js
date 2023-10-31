import React from 'react';
import ReactDOM from 'react-dom/client';
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import './index.css';

import Home from "./pages/Home/Home";
import AddQuestion from "./pages/AddQuestion/AddQuestion";
import Questions from "./pages/Questions/Questions";

const router = createBrowserRouter([
    {
        path: "/",
        element: <Home />,
    },
    {
        path: "/question",
        children: [
            {
                path: "",
                element: <Questions />,
            },
            {
                path: "new",
                element: <AddQuestion />,
            }
        ]
    }

]);

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <React.StrictMode>
        <RouterProvider router={router} />
    </React.StrictMode>
);
