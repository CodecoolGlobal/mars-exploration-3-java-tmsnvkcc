import {
  Route,
  RouterProvider,
  createBrowserRouter,
  createRoutesFromElements,
} from 'react-router-dom';
import {
  AddQuestion,
  Home,
  Questions
} from "pages";

const router = createBrowserRouter(createRoutesFromElements(
  <Route path={'/'}>
    <Route index element={<Home />} />
    <Route path={'add-question'} element={<AddQuestion />} />
    <Route path={'questions'} element={<Questions />} />
  </Route>
));

const Application = () => {
  return (
    <RouterProvider router={router} />
  );
};

export default Application;
