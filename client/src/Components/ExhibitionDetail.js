import PropTypes from 'prop-types'
// import React, { Component } from 'react'
import * as React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import { CardActionArea } from '@mui/material';
import axios from "axios";
import { useParams } from 'react-router-dom';

const baseURL = "http://localhost:8080/smartMuseum/exhibition/"

export default function ExhibitionDetail() {

  const { exhibitionId } = useParams()
  console.log(exhibitionId);
  const [exhibitionData, setExhibitionData] = React.useState(null);

  React.useEffect(() => {
      axios.get(baseURL.concat(exhibitionId)).then((response) => {
          console.log('before setting artwork data to json', response.data);
          setExhibitionData(response.data);
          console.log('after setting artwork data to json', exhibitionData);
      })
  }, exhibitionData)

  return (
    <div style={{width: '100%'}}>
        <div style={{display: 'flex', width: '100%', alignItems: 'center', justifyContent: 'center'}}>
            <Card sx={{ maxWidth: 500, marginTop: '20px', width: 500}}>
                <CardContent>
                    <Typography gutterBottom variant="h6" component="div">
                    {exhibitionData && exhibitionData.exhibitionName}
                    </Typography>
                    <Typography variant="body2" color="text.secondary">
                    {exhibitionData && exhibitionData.exhibitionBio}
                    </Typography>
                </CardContent>
            </Card>
        </div>
        <div style={{display: 'flex', width: '100%', alignItems: 'center', justifyContent: 'center'}}>
            <Card sx={{ maxWidth: 500, marginTop: '20px', width: 500}}>
                <CardContent>
                    <Typography gutterBottom variant="h6" component="div">
                    Information
                    </Typography>
                    <div style={{display: 'table'}}>
                        <div style={{display: 'flex'}}>
                          <Typography variant="body2" color="text.primary">
                          Founders &nbsp;
                          </Typography>
                          <Typography variant="body2" color="text.secondary">
                          {exhibitionData && exhibitionData.founders}
                          </Typography>
                        </div>
                        <div style={{display: 'flex'}}>
                          <Typography variant="body2" color="text.primary">
                          Founded Date &nbsp;
                          </Typography>
                          <Typography variant="body2" color="text.secondary">
                          {exhibitionData && exhibitionData.foundedDate}
                          </Typography>
                        </div>
                        <div style={{display: 'flex'}}>
                          <Typography variant="body2" color="text.primary">
                          Country &nbsp;
                          </Typography>
                          <Typography variant="body2" color="text.secondary">
                          {exhibitionData && exhibitionData.countryName}
                          </Typography>
                        </div>
                    </div>
                </CardContent>
            </Card>
        </div>
    </div>
  )
  
}