import React from "react";
import SingleItem from "./SingleItem";
import { Link, useLocation } from "react-router-dom";

const ItemList = ({ path, title, items, itemsArray, idPath }) => {
  const { pathname } = useLocation();
  const isHome = pathname === "/";

  const finalItems = isHome ? items : Infinity;

  //console.log({ itemsArray });
  return (
    <>
      <div className="item-list">
        <div className="item-list__header">
          <h2>{title} Populares</h2>

          {isHome ? (
            <Link className="item-list__link" to={path}>
              Mostrar Tudo
            </Link>
          ) : (
            <></>
          )}
        </div>

        <div className="item-list__container">
          {itemsArray
            .filter((currentValue, index) => index < finalItems)
            .map((currObj, index) => (
              <SingleItem
                {...currObj}
                idPath={idPath}
                key={`${title}-${index}`}
              />
            ))}
        </div>
      </div>
    </>
  );
};

export default ItemList;
