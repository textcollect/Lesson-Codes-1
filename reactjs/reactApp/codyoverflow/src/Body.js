import React from 'react';
import { comments } from './commentData';

// return a <p> element that contains the comment property from props.
function Body(props) {
    return <p>{props.comment}</p>;
}

export default Body;