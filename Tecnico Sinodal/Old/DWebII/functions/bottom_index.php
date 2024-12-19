<?php 

	$current_key = array_search($aula_atual, array_keys($aulas));
	$keys = array_keys($aulas);
	$anterior_url = array_key_exists($current_key-1, $keys) ? $aulas[$keys[$current_key-1]]['url'] : "";
	$proxima_url = array_key_exists($current_key+1, $keys) ? $aulas[$keys[$current_key+1]]['url'] : "";

?>


		<div class="bottom-index" <?php if ($aula_atual == 'inicio') { echo 'style="margin-top: 0"';}?> >
			<?php if ($aula_atual != 'inicio') { ?>
				<div class="anterior">
					<a href="<?php echo $anterior_url; ?>"> <button>&larr; Aula Anterior</button></a>
				</div>
			
				<?php if ($proxima_url) { ?>
					<div class="proxima">

						<a href="<?php echo $proxima_url; ?>" ><button>Próxima Aula &rarr;</button></a>
					</div>
				<?php } ?>

			<?php } ?>

			<div class="indice">
				<h4>Índice de aulas</h4><br>
				<ul>
					
					<?php foreach ($aulas as $key => $value) {
						
						if ($key == $aula_atual) { ?>
							<li class="aula_atual"><?php echo $value['nome']; ?></li>
						<?php } else { ?>
							<li><a href="<?php echo $value['url']; ?>"><?php echo $value['nome']; ?></a></li>
						
						<?php }
					} ?>
				
				</ul>
			</div>

		</div>