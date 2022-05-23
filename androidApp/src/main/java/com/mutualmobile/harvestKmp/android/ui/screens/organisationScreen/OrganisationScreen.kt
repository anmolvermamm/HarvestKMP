package com.mutualmobile.harvestKmp.android.ui.screens.organisationScreen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.mutualmobile.harvestKmp.android.R
import com.mutualmobile.harvestKmp.android.ui.screens.organisationScreen.components.OrganisationInputView
import com.mutualmobile.harvestKmp.android.ui.theme.*

@Composable
fun OrganisationScreen() {

  val scaffoldState = rememberScaffoldState()

  Scaffold(
    backgroundColor = MaterialTheme.colors.backgroundColor,
    contentColor = MaterialTheme.colors.textColor,
    modifier = Modifier
      .statusBarsPadding()
      .navigationBarsPadding(),
    scaffoldState = scaffoldState,
    snackbarHost = {
      scaffoldState.snackbarHostState
    }
  ) { innerPadding ->
    Box(modifier = Modifier.padding(innerPadding)) {
      Surface(
        color = MaterialTheme.colors.backgroundColor,
        modifier = Modifier
      ) {
        ConstraintLayout(
          modifier = Modifier
            .padding(12.dp)
            .navigationBarsPadding().imePadding()
            .fillMaxHeight()
            .fillMaxWidth()
        ) {
          // Create references for the composables to constrain
          val (inputView, subtitle, button) = createRefs()

          OrganisationInputView(modifier = Modifier.constrainAs(inputView) {
            top.linkTo(parent.top)
            bottom.linkTo(button.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
          })
          Text(
            stringResource(id = R.string.subtitle_this_address_harvest),
            modifier = Modifier
              .fillMaxWidth()
              .wrapContentWidth(align = Alignment.Start)
              .constrainAs(subtitle){
                top.linkTo(inputView.bottom)
              },
            style = ReportCardTypography.subtitle2.copy(
              color = MaterialTheme.colors.textColor.copy(alpha = 0.8f),
              fontWeight = FontWeight.Normal,
              textAlign = TextAlign.Start
            )
          )
          Button(
            onClick = {},
            modifier = Modifier
              .fillMaxWidth()
              .height(50.dp)
              .padding(top = 8.dp)
              .constrainAs(button) {
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
              },
            colors = ButtonDefaults.buttonColors(
              backgroundColor = MaterialTheme.colors.buttonColor
            )
          ) {
            Text(
              text = "Next",
              style = ReportCardTypography.subtitle2.copy(color = MaterialTheme.colors.buttonTextColor)
            )
          }
        }
      }
    }
  }
}
