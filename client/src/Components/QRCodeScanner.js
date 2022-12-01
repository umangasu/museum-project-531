import PropTypes from 'prop-types'
// import React, { Component } from 'react'

import React, { Component } from 'react'
import QrReader from 'react-qr-scanner'

class QRCodeScanner extends Component {
  constructor(props){
    super(props)
    this.state = {
      delay: 100,
      result: '',
    }

    this.handleScan = this.handleScan.bind(this)
  }
  handleScan(data){
    this.setState({
      result: data,
    })
    console.log("bruh")
    // window.open("/artists/")
  }
  handleError(err){
    console.error(err)
  }
  render(){
    const previewStyle = {
      height: 550,
      width: 550,
    }

    return(
      <div style={{display: 'flex', width: '100%', alignItems: 'center', justifyContent: 'center', marginTop: '50px'}}>
        <QrReader
          delay={this.state.delay}
          style={previewStyle}
          onError={this.handleError}
          onScan={this.handleScan}
          />
        <p>{this.state.result}</p>
      </div>
    )
  }
}

export default QRCodeScanner