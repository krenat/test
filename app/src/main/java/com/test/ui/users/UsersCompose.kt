package com.test.ui.users

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.skydoves.landscapist.glide.GlideImage
import com.test.R
import com.test.model.User

@Composable
fun UsersScreen(viewModel: UsersViewModel) {
    val users: List<User> = viewModel.users
    val countUsers = viewModel.inputCountUsers
    val buttonEnabled = viewModel.buttonEnabled
    val error = viewModel.error
    val isLoading = viewModel.isLoading

    LazyColumn(Modifier.padding(horizontal = 16.dp)) {
        item {
            Column {
                TextField(
                    value = countUsers,
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    onValueChange = { viewModel.onChangeCountUsers(it) },
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = colorResource(R.color.text),
                        backgroundColor = colorResource(R.color.input_background),
                        cursorColor = colorResource(R.color.purple_500),
                        focusedIndicatorColor = colorResource(R.color.purple_500),
                        unfocusedIndicatorColor = colorResource(R.color.purple_200)),
                    modifier = Modifier.fillMaxWidth()
                )
                Row {
                    Button(
                        onClick = { viewModel.updateUsers() },
                        enabled = buttonEnabled,
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Update")
                    }
                    Spacer(Modifier.width(8.dp))
                    Button(
                        onClick = { viewModel.toHistory() },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("History")
                    }
                }
            }
        }
        if(error.isNotEmpty() || isLoading) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 32.dp, horizontal = 16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    if(isLoading) {
                        Text(
                            text = "Loading",
                            color = Color.Blue
                        )
                    } else {
                        Text(
                            text = error,
                            color = Color.Red
                        )
                    }
                }
            }
        } else {
            items(users.size) {
                UserItem(users[it]) { viewModel.showUserDetails(it) }
            }
        }
    }
}

@Composable
private fun UserItem(user: User, onUserClicked: (String) -> Unit) {
    Row(Modifier
        .padding(8.dp)
        .clickable { onUserClicked(user.login.uuid) }
    ) {
        GlideImage(
            user.picture.thumbnail,
            requestOptions = {
                RequestOptions.bitmapTransform(RoundedCorners(8))
            },
            previewPlaceholder = R.drawable.ic_smile,
            modifier = Modifier.width(36.dp).height(36.dp)
        )
        Column(Modifier.padding(4.dp)) {
            Text(
                text = user.getName(),
                color = colorResource(R.color.text)
            )
            Text(
                text = user.cell,
                color = colorResource(R.color.text)
            )
            Text(
                text = user.email,
                color = colorResource(R.color.text)
            )
        }
    }
}
