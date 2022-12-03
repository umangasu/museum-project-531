import PropTypes from 'prop-types'
// import React, { Component } from 'react'
import * as React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import { CardActionArea } from '@mui/material';
import axios from "axios";
import { Link } from "react-router-dom";

const baseURL = "http://localhost:8080/smartMuseum/artworks"

export default function Artwork() {

  const [artworkData, setArtworkData] = React.useState(null);

  React.useEffect(() => {
    async function fetchData() {
        const resp = await axios.get(baseURL);
        // console.log(resp.data);
        setArtworkData(resp.data);
    }
    fetchData();
  },[])

  return (
    <div style={{
      display: 'flex', 
      justifyContent: 'space-around',
      marginTop: '20px', 
      alignItems: 'center',
      flexWrap: 'wrap'
    }}>
      {artworkData && artworkData.map((artwork, index) => (
        <Link 
        to={`/artworks/${artwork && artwork['artworkID']}`}
        style={{
          textDecoration: 'None'
        }}
      >
          <Card sx={{ maxWidth: 345, marginTop: '20px' }}>
            <CardActionArea>
              <CardMedia
                component="img"
                height="300"
                image={artwork && artwork['imageUrl']}
                alt="green iguana"
              />
              <CardContent>
                  <Typography gutterBottom variant="h6" component="div">
                    {artwork && artwork['title']}
                  </Typography>
              </CardContent>
            </CardActionArea>
          </Card>
        </Link>
      ))}
    </div>
  )
  
}