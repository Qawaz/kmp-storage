# Compose Mind Mapper

## Description

**Compose Mind Mapper ** is a multiplatform library to create mindmaps

### Usage

```kotlin
val mapColors = remember {
    listOf(
        Color.White,
        Color.Black,
        Color.Blue,
        Color.Cyan,
        Color.Green,
        Color.Magenta,
        Color.Red,
        Color.Gray
    )
}

val layoutMapperState = remember { LayoutMapper(LayoutMapState()) }
val canvasMapperState = remember { CanvasMapper(CanvasMapState()) }

var isCanvas by remember { mutableStateOf(true) }
val currentMapper = if (isCanvas) canvasMapperState else layoutMapperState

//    printStateWithInterval(layoutMapperState)
val colors = MaterialTheme.colors

Column(Modifier.background(MaterialTheme.colors.background)) {

    TopAppBar {
        Row(Modifier.weight(1f)) {
            IconButton(onClick = { isCanvas = !isCanvas }) {
                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = null
                )
            }
        }
        IconButton(onClick = { currentMapper.fitInViewport() }) {
            Icon(
                imageVector = Icons.Default.Face,
                contentDescription = null
            )
        }
    }

    if (isCanvas) {
        BoxWithConstraints(
            Modifier.fillMaxWidth().weight(1f).zoomableCanvasInput(canvasMapperState)
        ) {
            Canvas(
                modifier = Modifier.zoomableCanvasMap(canvasMapperState.zoom).fillMaxSize()
            ) {
                with(getMapperScope(state = canvasMapperState, colors = colors)) {
                    drawMindMap()
                }
            }

            ZoomableControllers(Modifier.align(Alignment.BottomEnd).padding(end = 16.dp, bottom = 16.dp), zoomableState = canvasMapperState.zoom)
        }
    } else {
        BoxWithConstraints(Modifier.fillMaxWidth().weight(1f)) {

            layoutMapperState.viewportWidth = constraints.maxWidth.toFloat()
            layoutMapperState.viewportHeight = constraints.maxHeight.toFloat()

            Mapper(
                modifier = Modifier.zoomableMap(layoutMapperState.zoom).fillMaxSize().onSizeChanged {
                    layoutMapperState.mapWidth = it.width
                    layoutMapperState.mapHeight = it.height
                },
                state = layoutMapperState,
            )
        }
    }

    fun onGetNodeColor(): Array<Color> = arrayOf(mapColors.random(), mapColors.random())

    if (isCanvas) {
        CanvasMapperTools(
            modifier = Modifier.fillMaxWidth(),
            state = canvasMapperState,
            onGetNodeColor = ::onGetNodeColor,
            onColor = {
                //show color dialog
            }
        )
    } else {
        BasicMapperTools(
            modifier = Modifier.fillMaxWidth(),
            state = layoutMapperState,
            onGetNodeColor = ::onGetNodeColor,
            onColor = {
                // show color dialog
            },
        )
    }
}
```