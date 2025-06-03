import React from "react";
import logoSpotify from "../assets/logo/spotify-logo.png";

const Header = () => {
  return (
    <>
      <div className="header">
        <div className="header__logo">
          <img src={logoSpotify} alt="Logo Spotify" />
        </div>
        <div className="header__title">
          <a href="/">
            <h1>Spotify</h1>
          </a>
        </div>
      </div>
    </>
  );
};

export default Header;
